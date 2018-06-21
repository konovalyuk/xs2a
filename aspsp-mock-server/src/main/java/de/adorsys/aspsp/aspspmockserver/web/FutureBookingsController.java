/*
 * Copyright 2018-2018 adorsys GmbH & Co KG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.adorsys.aspsp.aspspmockserver.web;

import de.adorsys.aspsp.aspspmockserver.service.FutureBookingsService;
import de.adorsys.aspsp.xs2a.spi.domain.account.SpiAccountDetails;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/future-bookings")
public class FutureBookingsController {
    private final FutureBookingsService futureBookingsService;

    @Autowired
    public FutureBookingsController(FutureBookingsService futureBookingsService) {
        this.futureBookingsService = futureBookingsService;
    }

    @ApiOperation(value = "", authorizations = {@Authorization(value = "oauth2", scopes = {@AuthorizationScope(scope = "read", description = "Access read API")})})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = SpiAccountDetails.class),
        @ApiResponse(code = 404, message = "Not Found")})
    @PostMapping(path = "/{iban}/{currency}")
    public ResponseEntity<SpiAccountDetails> changeBalances(@PathVariable("iban") String iban, @PathVariable("currency") String currency) throws Exception {
        return futureBookingsService.changeBalances(iban, currency)
                   .map(saved -> new ResponseEntity<>(saved, OK))
                   .orElse(ResponseEntity.notFound().build());
    }
}

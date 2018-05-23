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

package de.adorsys.aspsp.xs2a.spi.domain.consent.ais;

import com.fasterxml.jackson.annotation.JsonFormat;
import de.adorsys.aspsp.xs2a.spi.domain.consent.SpiAccountAccess;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AisConsentRequest {
    private String psuId;
    private String tppId;
    private int frequencyPerDay;
    private boolean withBalance;
    private AisAccountAccessInfo access;
    @JsonFormat(pattern="dd.MM.yyyy HH:mm")
    private LocalDateTime validUntil;
    private boolean recurringIndicator;
    private boolean tppRedirectPreferred;
    private boolean combinedServiceIndicator;
}
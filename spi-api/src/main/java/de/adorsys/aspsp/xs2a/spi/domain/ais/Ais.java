package de.adorsys.aspsp.xs2a.spi.domain.ais;

import de.adorsys.aspsp.xs2a.spi.domain.*;
import de.adorsys.aspsp.xs2a.spi.domain.delete_extra_class.Authentication;
import de.adorsys.aspsp.xs2a.spi.domain.delete_extra_class.Challenge;
import lombok.Data;

import java.util.Date;

@Data
public class Ais {
	private Tpp tpp;
	private String access_token;
	private Date request_timestamp;
	private Authentication[] sca_methods;
	private Authentication chosen_sca_method;
	private Challenge sca_challenge_data;
	private PsuUser psu;
	private AccountDetails psu_accountDetails;
	private SingleAccountAccess[] accounts;
	private Date date_from;
	private Date date_to;
	private String valid_until;
	private Integer frequency_per_day;
	private boolean recurring_indicator;
	private boolean combined_service_indicator;
}


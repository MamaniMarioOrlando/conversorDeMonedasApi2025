package model;

import java.util.Map;

public record CurrencyDto(
        String result,
        String documentation,
        String terms_of_use,
        long time_last_update_unix,
        String time_last_update_utc,
        String base_code,
        Map<String,Double> conversion_rates
) {
}

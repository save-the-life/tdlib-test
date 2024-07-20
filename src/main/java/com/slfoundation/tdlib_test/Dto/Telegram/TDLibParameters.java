package com.slfoundation.tdlib_test.Dto.Telegram;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.telegram.client")
@AllArgsConstructor
@NoArgsConstructor
public class TDLibParameters {

    private Boolean useMessageDatabase;
    private Boolean useSecretChats;
    private Integer apiId;
    private String apiHash;
    private String systemLanguageCode;
    private String deviceModel;
    private String applicationVersion;
    private Boolean enableStorageOptimizer;

}

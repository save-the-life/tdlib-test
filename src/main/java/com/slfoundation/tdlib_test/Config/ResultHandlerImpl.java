package com.slfoundation.tdlib_test.Config;

import com.slfoundation.tdlib_test.Dto.Telegram.TDLibParameters;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResultHandlerImpl implements Client.ResultHandler{

    private final TDLibParameters tdLibParameters;

    @Setter
    private Client client;

    @Override
    public void onResult(final TdApi.Object update) {
        if (update.getClass().equals(TdApi.UpdateAuthorizationState.class)) {
            var authStateUpdate = (TdApi.UpdateAuthorizationState) update;

            if (authStateUpdate.authorizationState.getClass()
                    .equals(TdApi.AuthorizationStateWaitTdlibParameters.class)){
                client.send(createRequest(), null);
            }
        }
    }

    private TdApi.SetTdlibParameters createRequest() {
        TdApi.SetTdlibParameters setTdlibParameters = new TdApi.SetTdlibParameters();
        setTdlibParameters.apiId = tdLibParameters.getApiId();
        setTdlibParameters.apiHash = tdLibParameters.getApiHash();
        setTdlibParameters.useMessageDatabase = tdLibParameters.getUseMessageDatabase();
        setTdlibParameters.useSecretChats = tdLibParameters.getUseSecretChats();
        setTdlibParameters.systemLanguageCode = tdLibParameters.getSystemLanguageCode();
        setTdlibParameters.deviceModel = tdLibParameters.getDeviceModel();
        setTdlibParameters.applicationVersion = tdLibParameters.getApplicationVersion();

        return setTdlibParameters;
    }

}

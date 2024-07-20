package com.slfoundation.tdlib_test.Config;

import com.slfoundation.tdlib_test.Exception.LibraryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TelegramConfiguration {

    @Bean
    public Client client(final ResultHandlerImpl resultHandler) throws Client.ExecutionException, LibraryNotFoundException {
        loadLibraries();
        Client.execute(new TdApi.SetLogVerbosityLevel(0));
        Client.execute(new TdApi.SetLogStream(new TdApi.LogStreamFile("tdlib.log", 134217728L, false)));

        Client client = Client.create(resultHandler, (Client.ExceptionHandler) null, (Client.ExceptionHandler) null);

        resultHandler.setClient(client);

        return client;
    }

    private void loadLibraries() throws LibraryNotFoundException {
        try {
            String os = System.getProperty("os.name");
            if (os != null && os.toLowerCase().startsWith("windows")) {
                System.loadLibrary("libcrypto-1_1-x64");
                System.loadLibrary("libssl-1_1-x64");
                System.loadLibrary("zlib1");
            }
            System.loadLibrary("tdjni");
        } catch (UnsatisfiedLinkError e) {
            throw new LibraryNotFoundException(e);
        }
    }

}

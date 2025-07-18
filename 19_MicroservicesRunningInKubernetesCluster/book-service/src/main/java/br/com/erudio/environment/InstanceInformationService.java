package br.com.erudio.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class InstanceInformationService implements ApplicationListener<WebServerInitializedEvent> {

    private String port;

    @Value("${HOSTNAME:LOCAL}")
    private String hostName;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.port = String.valueOf(event.getWebServer().getPort());
    }

    public String retrieveServerPort() {
        return port;
    }

    public String retrieveInstanceInfo() {
        return hostName.substring(hostName.length()-5);
    }

}

package com.lili.controller;




import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HelloController {
    private final Logger logger =  Logger.getLogger(getClass());

    @Autowired
    private Registration registration;
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        ServiceInstance instance = serviceInstance();
        String result = "/hello, host:port=" + instance.getUri() + "," + "service_id=" + instance.getInstanceId();
        logger.info(result);
        return "Hello world";
    }

    public ServiceInstance serviceInstance() {
        List<ServiceInstance> instances = client.getInstances(registration.getServiceId());
        if (instances != null && instances.size() > 0) {
            for (ServiceInstance sit : instances) {
                if (sit.getPort() == 2222) {
                    return sit;
                }
            }
        }
        return null;
    }
}

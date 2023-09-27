package com.kun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertorTest {

    @Test
    void convert() {
        //String s = "{Name:od-simulation-optimizer AvailableIPs:[10.205.138.122]}";
        //String s = "{AppStatus:{Name:od-v6-58-36dd9c7-simulator AvailableIPs:[10.205.109.100 10.205.114.133 10.205.99.169]}";
        //String s ="{JobTag:20230913062958_915359aeebed1e568d32a193cd3106be Simulator:{AppSpec:{Name:od-v6-58-36dd9c7-simulator Namespace: Size:3 DeployType:0} MinSize:1} Apps:[{Name:od-v6-58-36dd9c7-aggregator Namespace: Size:1 DeployType:0} {Name:od-v6-58-36dd9c7-counter Namespace: Size:1 DeployType:0} {Name:od-v6-58-36dd9c7-player Namespace: Size:1 DeployType:0} {Name:od-v6-58-36dd9c7-fc Namespace: Size:1 DeployType:0} {Name:od-simulation-optimizer Namespace:ondemand Size:1 DeployType:1}]}";
        String s ="{Ready:true Error: Simulators:{AppStatus:{Name:od-v6-58-36dd9c7-simulator AvailableIPs:[10.205.109.100 10.205.114.133 10.205.99.169]}} Apps:[{Name:od-v6-58-36dd9c7-aggregator AvailableIPs:[10.205.124.104]} {Name:od-v6-58-36dd9c7-counter AvailableIPs:[10.205.103.69]} {Name:od-v6-58-36dd9c7-player AvailableIPs:[10.205.99.46]} {Name:od-v6-58-36dd9c7-fc AvailableIPs:[10.205.121.223]} {Name:od-simulation-optimizer AvailableIPs:[10.205.138.122]}]}";
        System.out.println(Convertor.convert(s));
    }
}
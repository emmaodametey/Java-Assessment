package org.example.services;

import org.example.vm.VirtualMachine;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RequestEngine implements VirtualMachineRequestor{
    private String userLogonName;
    private LocalDate today = LocalDate.now();
    private AuthServ auth = new AuthServ();
    private VirtualMachine machine;
    private int failedBuilds;
    private static Map<String, Map<String, Integer>> buildsbyUsers;
    private Map<String, Integer> buildByUser;


    public RequestEngine(String user) {
        this.userLogonName = user;
        buildsbyUsers = new HashMap<>();
    }

    @Override
    public void createNewRequest(VirtualMachine machine) throws UserNotEntitledException, MachineNotCreatedException {
        if(!auth.isAuthorised(this.userLogonName)){
            throw new UserNotEntitledException("user not entitled");
        }
        BuildNewMachine build = new BuildNewMachine();

        if(build.createNewMachine(this.machine) == null){
            this.failedBuilds++;
            throw new MachineNotCreatedException("machine not created");
        }
        setMachine(machine);


    }

    @Override
    public Map<String, Map<String, Integer>> totalBuildsByUserForDay() {
        return null;
    }

    @Override
    public int totalFailedBuildsForDay() {
        return failedBuilds;
    }

    public void setMachine(VirtualMachine machine) {
        this.machine = machine;
    }

    public static Map<String, Map<String, Integer>> getBuildsbyUsers() {
        return buildsbyUsers;
    }

    public Map<String, Integer> getBuildByUser() {
        return buildByUser;
    }
}

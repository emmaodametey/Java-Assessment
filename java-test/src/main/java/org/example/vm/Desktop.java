package org.example.vm;

public class Desktop extends VirtualMachine{
    private int microsoftWindowsVersion;
    private String buildNumber;

    public Desktop(String hostName, String requester, int numberOfCpu,
                   int sizeOfRam, int sizeOfHardDisk, int microsoftWindowsVersion, String buildNumber) {
        super(hostName, requester, numberOfCpu, sizeOfRam, sizeOfHardDisk);
        this.microsoftWindowsVersion = microsoftWindowsVersion;
        this.buildNumber = buildNumber;
    }

}

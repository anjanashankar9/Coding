package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-18
 */
public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> ipAddr = new ArrayList<>();

        if(s.length()< 4 || s.length() > 12)
            return ipAddr;

        restoreIpAddresses(s, 0, new ArrayList(), ipAddr);
        return ipAddr;
    }

    private void restoreIpAddresses(String s, int index, List<String> ipAddrPart, List<String> ipAddr) {
        // If we have reached the end of string or
        // we have 4 octets.
        if(ipAddrPart.size()>4)
            return;
        if(!ipAddrPart.isEmpty() && ipAddrPart.size() == 4 && index == s.length()) {
            if(isValid(ipAddrPart))
                ipAddr.add(String.join(".", ipAddrPart));
        }
        for(int i=1; i<=3; i++) {
            if(index+i <= s.length()) {
                ipAddrPart.add(s.substring(index, index+i));
                restoreIpAddresses(s, index+i, ipAddrPart, ipAddr);
                ipAddrPart.remove(ipAddrPart.size()-1);
            }
        }
    }

    private boolean isValid(List<String> ipPart)
    {
        if(ipPart.size()!=4) {
            return false;
        }
        for (String s : ipPart) {
            int i = Integer.parseInt(s);
            if (s.length() > 3 || i < 0 || i > 255) {
                return false;
            }
            // The substring cannot be 00
            if (s.length() > 1 && i == 0)
                return false;

            // The substring cannot begin with 0, apart from the case .0.
            if (s.length() > 1 && i != 0
                    && s.charAt(0) == '0')
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "100100";
        List<String> result = new RestoreIpAddress().restoreIpAddresses(s);
        for(String str: result) {
            System.out.println(str);
        }
    }
}

/*
A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.



Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "1111"
Output: ["1.1.1.1"]
Example 4:

Input: s = "010010"
Output: ["0.10.0.10","0.100.1.0"]
Example 5:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


Constraints:

0 <= s.length <= 3000
s consists of digits only.
 */

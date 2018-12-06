// 468. Validate IP Address ---------- medium

class LC468 {
    public String validIPAddress(String IP) {
        if (IP.indexOf(".") != -1 && IP.indexOf(":") != -1) return "Neither";
        if (IP.indexOf(".") != -1 && isIpv4(IP)) return "IPv4";
        if (IP.indexOf(":") != -1 && isIpv6(IP)) return "IPv6";
        return "Neither";
    }
    
    private boolean isIpv4(String ip)
    {
        if (ip.indexOf(".") == 0 || ip.lastIndexOf(".") == ip.length() - 1) return false;
        String[] ips = ip.split("\\.");
        if (ips.length != 4) return false;
        for (int i = 0; i < ips.length; i++)
        {
            if (ips[i].length() == 0) return false;
            if (ips[i].length() > 1 && ips[i].charAt(0) == '0') return false;
            int sum = 0;
            for (int j = 0; j < ips[i].length(); j++)
            {
                char c = ips[i].charAt(j);
                if (!Character.isDigit(c)) return false;
                sum  = sum * 10 + c - '0';
            }
            if (sum < 0 || sum > 255) return false;
        }
        return true;
    }
    
    private boolean isIpv6(String ip)
    {
        //System.out.println(ip);
        if (ip.indexOf(":") == 0 || ip.lastIndexOf(":") == ip.length() - 1) return false;
        String[] ips = ip.toLowerCase().split(":");
        if (ips.length != 8) return false;
        //System.out.println(ip);
        for (int i = 0; i < ips.length; i++)
        {
            String part = ips[i];
            if (part.length() > 4 || part.length() == 0) return false;
            for (int j = 0; j < part.length(); j++)
            {
                char c = part.charAt(j);
                if (c == '0') continue;
                else if (c >= 'a' && c <= 'f') continue;
                else if (Character.isDigit(c)) continue;
                else return false;
            }
        }
        return true;
    }
}
// 929. Unique Email Addresses
// The idea is simple, first find the index of '@', this is to split the string
// into two parts, first part is username, second is domain name.
// Then, scan through the first part, if the character is '+', ingore everything after current
// if the chacater is '.', ignore only this character. After the scan, concatnate the result 
// with the domain name part.
class LC929 {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String s : emails)
        {
            // O(s.length()), so total is O(sum(s.length()))
            int indexAt = s.indexOf("@");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < indexAt; i++)
            {
                if (s.charAt(i) == '+') break;
                else if (s.charAt(i) == '.') continue;
                else sb.append(s.charAt(i));
            }
            s = sb.toString() + s.substring(indexAt, s.length());
            set.add(s);
        }
        return set.size();
    }
}
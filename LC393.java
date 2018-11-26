// Beware of this question... the description is a big mess for people who don't 
// familiar with UTF-8 encoding
class LC393 {
    public boolean validUtf8(int[] data) {
        int index = 0;
        while (index < data.length)
        {
            int count = 0;
            int start = data[index++];
            int help = 1 << 7;
            // Retrieve how many bytes this character used
            while ((help & start) > 0)
            {
                count++;
                help >>= 1;
            }
            // UTF-8 should be 1~4 bytes long so any character start with 10xxxxxx or more than 11110111
            // will be invalid
            if (count == 1 || count > 4) return false;
            if (count == 0) continue;
            for (int i = 0; i < count - 1; index++, i++)
            {
                if (index == data.length) return false;
                int mask = 0x80;
                if ((data[index] & mask) != 0x80) return false;
            }
        }
        return true;
    }
}
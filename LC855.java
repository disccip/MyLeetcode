// 855. Exam Room --------- medium

class LC855 {
    private List<Integer> list;
    private int length;
    public ExamRoom(int N) {
        list = new ArrayList<>();
        length = N;
    }
    
    public int seat() {
        if (list.size() == 0)
        {
            list.add(0);
            return 0;
        }
        int distance = Math.max(list.get(0), length - 1 - list.get(list.size() - 1)), left = -1, right = -1;
        for (int i = list.size() - 1; i > 0; i--)
        {
            if (distance <= (list.get(i) - list.get(i - 1)) / 2)
            {
                right = list.get(i);
                left = list.get(i - 1);
                distance = (right - left) / 2;
            }
        }
        if (distance == list.get(0))
        {
            list.add(0, 0);
            return 0;
        }
        int index = (right + left) / 2;
        for (int i = 0; i < list.size() - 1; i++)
        {
            if (index > list.get(i) && index < list.get(i + 1))
            {
                list.add(i + 1, index);
                //System.out.printf("distance = %d, left = %d, right = %d, index = %d\n", distance, left, right, index);
                return index;
            }
        }
        list.add(length - 1);
        return length - 1;
    }
    
    public void leave(int p) {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) == p) 
            {
                list.remove(i);
                break;
            }
        }
    }
    
}
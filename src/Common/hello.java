class hello
{
    public static void main(String[] args) {
        int a[] = {1,3,5,9};
        int b[] = a;
        for (int i =0;i<4;i++)
        {
            System.out.print(b[i]+ " ");
        }
        System.out.println();
        a[0] = 99;
        for (int i =0;i<4;i++)
        {
            System.out.print(b[i]+ " ");
        }
    }
}
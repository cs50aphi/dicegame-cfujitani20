public class Die
{
    // Instance variables
    int sides;
    int range;
    // Constructor
    public Die(int s, int k)
    {
        sides = s;
        range = k;
    }
    public Die()
    {
        sides = 6;
        range = 149;
    }
    public int roll()
    {
        int r = (int)(Math.random() * sides) + 1;
        return r;
    }
    public int randomize()
    {
        int p = (int)(Math.random() * range);
        return p;
    }
    // public int roll(int min, int max)
    // {
    //     sides = max;
    //     int q = (int)(Math.random() * max);
    //     return q;
    // }
    // public void checkpoint(int k)
    // {
    //     range = k;
    // }
    // public Random()
    // {
    //     range = 99;
    // }
    // Methods


}
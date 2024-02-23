import processing.core.PApplet;

import java.util.Scanner;

public class TeacherCode extends PApplet {
    private static final double[] a = {0, 0.5, 0.5, 0};
    private static final double[] b = {0.5, 0, 0, -0.5};
    private static final double[] c = {0.5, 0, 0, -0.5};
    private static final double[] d = {0.0, 0.5, 0.5, 0.0};
    private static final double[] e = {0.0, 0, 0.5, 1.0};
    private static final double[] f = {0.0, 0.5, 0.5, 0.5};
    private static final int[] cX = {0, 162, 324, 486};
    private static final int[] cY = {2, 165, 328};
    public void settings(){
        size(512,512);
        smooth();
    }
    public void setup(){
        colorMode(HSB,360,255,255);
        background(0);
    }
    private static void set(int[][] p, int i, int j, short bit)
    {
        int n;
        n = p[i][j / 16];
        if (bit != 0)
        {
            n |= 1 << j % 16;
        }
        else
        {
            n &= ~(1 << (j % 16));
        }
        p[i][j / 16] = n;
    }
    private static short get(int[][] p, int i, int j)
    {
        short bit;
        int l;
        int n;
        n = p[i][j / 16];
//C++ TO JAVA CONVERTER WARNING: The right shift operator was not replaced by Java's logical right shift operator since the left operand was not confirmed to be of an unsigned type, but you should review whether the logical right shift operator (>>>) is more appropriate:
        return (short)((n >> j % 16) & 1);
    }
    void draw(int[][] p, int x, int y)
    {
        int[][] w = new int[160][10];
        int[][] v = new int[0][];
        int counter;
        int i;
        int j;
        int k = 1;
        int iNew;
        int jNew;
        System.out.print("option (1-10): ");
        init(k,w);
        for (counter = 0; counter < 12; counter++)
        {
            int i1;
            int j1;
            for (i1 = x; i1 < x + 160; i1++)
            {
                for (j1 = y; j1 < y + 160; j1++)
                {
                    if (get(w, i1 - cX[counter % 4], j1 - cY[counter / 4]) != 0)
                    {
                        point(i1,2 * cY[counter / 4] + 159 - j1);
                    }
                    else
                    {
                        point(i1,2 * cY[counter / 4] + 159 - j1); // draw a point on a position i, 2*y+159-j
                    }
                }
            }
            for (i = 0; i < 160; i++)
            {
                for (j = 0; j < 10;j++)
                {
                    v[i][j] = 0;
                }
            }
            for (i = 0; i < 160; i++)
            {
                for (j = 0; j < 160; j++)
                {
                    if (get(w, i, j)==1)
                    {
                        for (k = 0; k < 4; k++)
                        {
                            iNew = (int) (160 * (a[k] * i / 160.0 + b[k] * j / 160.0 + e[k]));
                            jNew = (int) (160 * (c[k] * i / 160.0 + d[k] * j / 160.0 + f[k]));
                            set(v, iNew,jNew, (short) 1);
                        }
                    }
                }
            }
            for (i = 0; i < 160; i++)
            {
                for (j = 0; j < 160; j++)
                {
                    set(w, i, j, get(v, i, j));
                    set(v, i,j, (short) 0);
                }
            }
        }

        System.out.print("option (1-10): ");


    }

    private static void init1(int[][] w)
    {
        int i;
        for (i = 1; i < 160; i++)
        {
            if (i < 80)
            {
                set(w, i, i, (short) 1);
                set(w, 159 - i, i, (short) 1);
            }
        }
    }
    private static void init2(int[][] w)
    {
        set(w, 79, 79, (short) 1);
    }
    private static boolean init(int i, int[][] w)
    {
        int k;
        int j;
        for (k = 0; k < 160; k++)
        {
            for (j = 0; j < 10; j++)
            {
                w[k][j] = 0; // this is to set the default value
            }
        }
        switch (i)
        {
            case 1:
                init1(w);
                break;
            case 2:
                init2(w);
                break;
        }
        return (0<i && i<11);
    }
    public static void main(String[] args)
    {
        String[] name = new String[] {"TeacherCode"};
        PApplet.main(name);
    }
}
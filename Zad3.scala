object Main extends App {
    def trojkat(wys: Int): Unit = {
        def helper(h: Int): Unit = {
            if( h > 0 ){
                helper(h-1)
            }
            print(" " * (wys - h))
            petla(h,h)
        }        
        def pascal(n: Int, k: Int): Int = {
            if(k == 0 || n == k) 1
            else pascal(n-1, k-1) + pascal(n-1, k)
        }
        def petla(h: Int, i: Int): Unit = {
            print(pascal(h, i) + "  ")
            if(i > 0)
            {
                petla(i-1, h)
            }
        }
        helper(wys)
    }
trojkat(7)
}
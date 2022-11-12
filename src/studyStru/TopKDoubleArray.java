package studyStru;
/**
 * 寻找两个升序数组中第K大的值
 */
public class TopKDoubleArray {
    //暴力解法：直接将两个数组合并成一个数组，再求解升序数组中的第K大数
    //使用两个指针分别对两个数组进行遍历来求解
    public static int findTopK(int[] arrA,int[] arrB,int k){
        //求出第k大对应的是两个数组之中第n小的数的索引
        int index = arrA.length+arrB.length - k;
        //使用两个指针对两个数组进行遍历
        int preA = 0,preB = 0 ;
        //用于判断是否有数组遍历完毕
        boolean end = false;
        //循环终止条件：已遍历元素 == k对应的索引
        while (index>0){
            //若两个数组都没有遍历完
            //若preA指向元素小于preB指向元素
            if(arrA[preA] <= arrB[preB]){
                //遍历元素个数+1，移动preA指针
                if(preA == arrA.length-1){
                    preB --;
                    break;
                }
                preA ++;

            }
            else{//若preA指向元素小于preB指向元素
                //遍历元素个数+1，移动preB指针
                if(preB == arrB.length-1){
                    preA--;
                    break;
                }
                preB++;
            }

            index --;
        }

        while (index>0){
            end = true;
            if(preA == arrA.length-1){
                preB++;
            }
            else {
                preA++;
            }
            index --;
        }
        if(end)
            return Math.max(arrA[preA],arrB[preB]);
        return Math.min(arrA[preA],arrB[preB]);
    }

    //由于数组是升序排列,所以可以使用二分查找的思想进行求解
    public static int findTopK2(int[] arrA,int la,int ra,int[] arrB,int lb,int rb,int k){
        if(k <= 0)
            return -1;
        //默认A数组不长于B数组
        if(arrA.length>arrB.length)
            findTopK2(arrB, lb, rb,arrA, la, ra, k);
        //递归结束条件：左边界>右边界
        if(la>=ra)
            return arrB[lb + k - 1];
        if(lb>rb)
            return arrA[la + k - 1];
        //获取两个数组的中间，数组的中间位置=数组中间大的数
        int midA = la+(ra-la)/2;
        int midB = lb+(rb-lb)/2;
        //统计从两个数组左边界到中间位置一共有多少个数sum
        int sum = midA - la + midB - lb + 2;
        if(arrA[midA]<arrB[midB]){//若A的中间值小于B的中间值，则数组A的范围从la-ra
            //若k小于sum，则说明可以排除掉midB~rb，数组A取值范围la~ra，数组B的取值范围lb~midB-1
            if(sum>k)
                return findTopK2(arrA, la, ra, arrB, lb, midB-1, k);
            //若大于等于，则说明可以排除掉la~midA，数组A取值范围midA+1~ra，数组B的取值范围lb~rb，k = k - (midA - la + 1)
            else
                return findTopK2(arrA, midA+1, ra, arrB, lb, rb, k - (midA - la + 1));
        }
        else {//若A的中间值大于等于B的中间值，则数组B的范围从lb-rb
            //若k小于sum，则说明可以排除掉midA~ra，数组A取值范围la~midA-1，数组B的取值范围lb~rb
            if(sum>k)
                return findTopK2(arrA, la, midA-1, arrB, lb, rb, k);

            //若大于等于，则说明可以排除掉lb~midB，数组A取值范围la~ra，数组B的取值范围midB+1~rb，k = k - (midB - lb + 1)
            else
                return findTopK2(arrA, la, ra, arrB, midB+1, rb, k - (midB - lb + 1));
        }

    }



    public static void main(String[] args) {
        int[] arrA = {1,3,4};
        int[] arrB = {2,5,8,9,10};
        int k = 5;
        System.out.println(findTopK2(arrA,0,arrA.length,arrB,0,arrB.length,arrA.length+arrB.length-k+1));
        System.out.println();
    }


}

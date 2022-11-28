package studyStru;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，
 * 返回矩阵中的所有元素。
 */
public class SpiralOrder {
    public static List<Integer> spiral(int[][] matrix) {
        //创建返回的链表
        List<Integer> res = new ArrayList<>();
        //获取螺旋列阵的上下左右边界；
        int top = 0, bottom = matrix.length-1;
        int left = 0, right = matrix[0].length-1;
        //获取二维矩阵中的所有元素，用于作为循环结束的条件
        //循环结束条件：存入的元素>=所有元素
        while(left <= right && top <=bottom) {
            //将上侧一层元素存入matrix[top][left~right],并将上边界+1
            for(int i = left; i <right+1 ;i++){
                res.add(matrix[top][i]);

            }
            top++;
            //将右侧一层元素存入matrix[top~bottom][right],并将右边界-1
            for(int i = top; i<bottom +1; i++){
                res.add(matrix[i][right]);

            }
            right--;

            if(right<left && top <bottom){
                //将下侧一层元素存入matrix[bottom][left~right],并将下边界-1
                for (int i = right ; i>left-1 ; i--){
                    res.add(matrix[bottom][i]);
                    System.out.println("bottom");
                }
                bottom --;
                //将左侧一层元素存入matrix[top~bottom][left],并将左边界+1
                for (int i = bottom ;i> top-1 ;i--){
                    res.add(matrix[i][left]);
                    System.out.println("left");
                }

                left++;
            }
        }
        //返回结果
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4}};
        List<Integer> list = spiral(arr);
        for (Integer num : list) {
            System.out.print(num+" ");
        }
    }
}

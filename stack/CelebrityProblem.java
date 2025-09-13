package stack;

public class CelebrityProblem {
  public static void main(String[] args) {
    int[][] M = {
      {0, 0, 1, 0},
      {0, 0, 1, 0},
      {0, 0, 0, 0},
      {0, 0, 1, 0}
    };
    CelebrityProblem cp = new CelebrityProblem();
    System.out.println(cp.celebrity(M));
  }

  public int celebrity(int[][] M) {
        int n = M.length;
        int left = 0;
        int right = n-1;

        while (left < right) {
            if (M[left][right] == 1) {
                left++;
            } else if (M[right][left] == 1) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        boolean isCeleb = true;

        for (int i=0; i<M.length; i++) {
          if (i != left) {
            if (M[left][i] == 1 || M[i][left] == 0) {
                isCeleb = false;
                break;
            }
          }
        }

        return isCeleb ? left : -1;
    }
}

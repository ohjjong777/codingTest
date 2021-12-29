package programmers;

/* 프로그래머스 로또의 최고 순위와 최저 순위 */

public class LottoMaxMinRanking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sl = new Solution();

		int[] answer;		
		
		//int[] lotts = {44, 1, 0, 0, 31, 25};
		//int[] win_nums = {31, 10, 45, 1, 6, 19};		
		//answer = [3, 5]
		//int[] lotts = {0, 0, 0, 0, 0, 0};
		//int[] win_nums = {38, 19, 20, 40, 15, 25};
		//answer = [1, 6]
		int[] lotts = {45, 4, 35, 20, 3, 9};
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		//answer = [1, 1]		
														
		answer = sl.solution(lotts, win_nums);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}

class Solution {
	
    public int[] solution(int[] lottos, int[] win_nums) {
    	
    	//lottos 배열과 win_nums 배열간 일치하는 원소의 개수
    	int matchCnt = 0;
    	
    	//lottos 배열의 원소 중 0인 개수    	
    	int zeroCnt = 0;
    	
    	//matchCnt와 zeroCnt를 더하여 최고순위 계산에 이용
    	int maxMatchCnt = 0;
    	
    	//최고순위와 최저순위를 저장할 배열선언
        int[] answer = new int[2];    	
    	
    	//lottos 배열의 원소를 win_nums 배열의 원소와 비교하여 몇개가 일치하는지 연산
    	for (int i = 0; i < lottos.length; i++) {

        	//lottos 배열의 원소에서 0이 몇개인지 연산    		
    		if (lottos[i] == 0) {
    			zeroCnt++;
    			continue;
    		}
    		
    		for (int j = 0; j < win_nums.length; j++) {
    			if (lottos[i] == win_nums[j]) {
    				matchCnt++;
    			}
    		}
    	}
    	
    	maxMatchCnt = matchCnt + zeroCnt;
    	
    	//7에서 maxMatchCnt를 차감하여 최고순위를 계산
    	if (maxMatchCnt == 0) {
    		answer[0] = 6;
    	} else {
    		answer[0] = 7 - maxMatchCnt;
    	}
    	
    	//7에서 matchCnt를 차감하여 최저순위를 계산
    	if (matchCnt == 0) {
    		answer[1] = 6;
    	} else {
    		answer[1] = 7 - matchCnt;
    	}    	

        return answer;
    }
}
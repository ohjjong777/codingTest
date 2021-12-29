package programmers;

/* ���α׷��ӽ� �ζ��� �ְ� ������ ���� ���� */

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
    	
    	//lottos �迭�� win_nums �迭�� ��ġ�ϴ� ������ ����
    	int matchCnt = 0;
    	
    	//lottos �迭�� ���� �� 0�� ����    	
    	int zeroCnt = 0;
    	
    	//matchCnt�� zeroCnt�� ���Ͽ� �ְ���� ��꿡 �̿�
    	int maxMatchCnt = 0;
    	
    	//�ְ������ ���������� ������ �迭����
        int[] answer = new int[2];    	
    	
    	//lottos �迭�� ���Ҹ� win_nums �迭�� ���ҿ� ���Ͽ� ��� ��ġ�ϴ��� ����
    	for (int i = 0; i < lottos.length; i++) {

        	//lottos �迭�� ���ҿ��� 0�� ����� ����    		
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
    	
    	//7���� maxMatchCnt�� �����Ͽ� �ְ������ ���
    	if (maxMatchCnt == 0) {
    		answer[0] = 6;
    	} else {
    		answer[0] = 7 - maxMatchCnt;
    	}
    	
    	//7���� matchCnt�� �����Ͽ� ���������� ���
    	if (matchCnt == 0) {
    		answer[1] = 6;
    	} else {
    		answer[1] = 7 - matchCnt;
    	}    	

        return answer;
    }
}
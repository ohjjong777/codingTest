package programmers;

/* ���α׷��ӽ� �ű� ���̵� ��õ */

public class NewIdRecommend {

	public static void main(String[] args) {
		
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		String answer;		
		
		SolutionNewIdRecommend sl = new SolutionNewIdRecommend();
															
		answer = sl.solution(new_id);
				
		System.out.print(answer);		
	}	
}

class SolutionNewIdRecommend {
	
    public String solution(String new_id) {
    	
        String answer = "";
        
        //��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ        
        answer = new_id.toLowerCase();
        
        //���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� ����
        answer = answer.replaceAll("[^a-z0-9-_\\.]", "");
        
        //��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ
        answer = answer.replaceAll("[\\.]{2,}", ".");
        
        //��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� ����
        answer = answer.replaceAll("^[\\.]", "");
        answer = answer.replaceAll("[\\.]$", "");        
        
        //�� ���ڿ��̶��, new_id�� "a"�� ����
        if (answer.equals("")) {
        	answer = "a";
        }
        
        //new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� ����
        //���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� ����        
        if (answer.length() >= 16) {
        	answer = answer.substring(0, 15);
            answer = answer.replaceAll("[\\.]$", "");        	
        }
        
        //new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ����
        if (answer.length() <= 2) {
        	
        	String lastLetter = answer.substring(answer.length() - 1);
        	
        	do {
        		answer = answer + lastLetter;
        	} while (answer.length() != 3);        	        
        }        
        
        return answer;
    }
}
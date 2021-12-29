package programmers;

/* 프로그래머스 신규 아이디 추천 */

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
        
        //모든 대문자를 대응되는 소문자로 치환        
        answer = new_id.toLowerCase();
        
        //알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        answer = answer.replaceAll("[^a-z0-9-_\\.]", "");
        
        //마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        answer = answer.replaceAll("[\\.]{2,}", ".");
        
        //마침표(.)가 처음이나 끝에 위치한다면 제거
        answer = answer.replaceAll("^[\\.]", "");
        answer = answer.replaceAll("[\\.]$", "");        
        
        //빈 문자열이라면, new_id에 "a"를 대입
        if (answer.equals("")) {
        	answer = "a";
        }
        
        //new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거        
        if (answer.length() >= 16) {
        	answer = answer.substring(0, 15);
            answer = answer.replaceAll("[\\.]$", "");        	
        }
        
        //new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
        if (answer.length() <= 2) {
        	
        	String lastLetter = answer.substring(answer.length() - 1);
        	
        	do {
        		answer = answer + lastLetter;
        	} while (answer.length() != 3);        	        
        }        
        
        return answer;
    }
}
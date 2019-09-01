package kakao_2018_openChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public String[] solution(String[] record) throws IOException {
		List<String> userIdList = new ArrayList<String>();
		HashMap<String, String> nicknameByID = new HashMap<String, String>();
		
		int commandCnt = 0;
		String[] answer;
		
		BufferedReader br;
		StringTokenizer input;
		for (int idx = 0; idx < record.length; idx++) {
			br = new BufferedReader(new StringReader(record[idx]));
			input = new StringTokenizer(br.readLine());
			String command = input.nextToken();

			if (command.equals("Leave")) {
				commandCnt++;
				continue;
			}
			
			String id = input.nextToken();
			String nickname = input.nextToken();

			switch (command) {
			case "Enter":
				commandCnt++;
				if (!nicknameByID.containsKey(id)) {
					userIdList.add(id);
				}
				break;
			case "Change":
				break;

			default:
				System.out.println("ERROR! : " + command);
				break;
			}
			
			nicknameByID.put(id, nickname);
		}
		////
		answer = new String[commandCnt];
		int answerIdx = 0;
		
		for(int idx = 0; idx<record.length; idx++) {
			br = new BufferedReader(new StringReader(record[idx]));
			input = new StringTokenizer(br.readLine());
			String command = input.nextToken();
			
			if(command.equals("Change")) {
				continue;
			}
			
			String id = input.nextToken();
			StringBuilder output = new StringBuilder(nicknameByID.get(id));
			
			switch (command) {
			case "Enter":
				output.append("님이 들어왔습니다.");
				break;
			case "Leave":
				output.append("님이 나갔습니다.");
				break;

			default:
				System.out.println("ERROR! : " + command);
				break;
			}
			
			answer[answerIdx++] = output.toString();
			
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		sol.solution(record);
	}
}

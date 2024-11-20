package org.wisesaying;

import java.util.Scanner;

public class App {
    WiseSaying[] wiseSayings;
    int countOfContact = 0;
    Scanner cmd; // 스캐너 활성화

    // 생성자
    public App() {
        wiseSayings = new WiseSaying[10];
    }

    // 메소드 - 등록
    public WiseSaying inputWiseSayingData() {
        String wisesaying = emptyCheckData("명언"); // 공백확인 후 대입
        String writer = emptyCheckData("작가");

        return new WiseSaying(wisesaying, writer); // 등록 객체 리턴
    }

    // 메소드 - 데이터 저장(배열에 객체)
    public void addWiseSaying(WiseSaying wiseSaying) {
        wiseSayings[countOfContact] = wiseSaying;
        countOfContact++;
        System.out.println(">>> " + countOfContact + "번 데이터가 저장되었습니다.\n");
    }

    // 메소드 - 명언 출력
    public void printWiseSaying(WiseSaying wiseSaying) {
        System.out.println(wiseSaying.getWiseSaying() + " / " + wiseSaying.getWriter());
    }

    // 메소드 - 모든 명언 출력
    public void printAllWiseSaying() {
        System.out.println("==============================================");
        if(wiseSayings[0] == null) {
            System.out.println("등록된 명언이 없습니다.");
        } else {
            System.out.println("번호 / 작가 / 명언");
            for(int i=0; i<countOfContact; i++) {
                System.out.print((i+1) + "번 / ");
                printWiseSaying(wiseSayings[i]);
            }
        }
        System.out.println("==============================================\n");
    }

    // 메소드 - 데이터 공백 확인
    public String emptyCheckData(String dataType) {
        cmd = new Scanner(System.in);

        while (true) {
            //데이터 타입 입력
            System.out.print(dataType + ": ");
            String inputData = cmd.nextLine();

            // 앞뒤공백제거 > 공백문자열 확인.
            if(inputData.trim().isEmpty()) {
                System.out.println("> 입력 오류ㅣ다시 입력해주세요.");
                continue; // 계속 입력
            } else {
                // System.out.println("> " + dataType + "이(가) 정상 입력되었습니다.");
                return inputData;
            }

        }
    }
}

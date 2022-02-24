package BOJ.sort.����_���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Applicant{
	int paper;
	int interview;
	
	Applicant(int paper, int interview){
		this.paper=paper;
		this.interview=interview;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer str;
		for(int i=0; i<T; i++) {
			int count=Integer.parseInt(br.readLine());
			int[] paper=new int[count];
			int[] interview=new int[count];
			
			ArrayList<Applicant> list=new ArrayList<>();

			for(int j=0; j<count; j++) {
				str=new StringTokenizer(br.readLine());
				paper[j]=Integer.parseInt(str.nextToken());//�������
				interview[j]=Integer.parseInt(str.nextToken());//�������
				
				list.add(new Applicant(paper[j], interview[j]));
				
			}
			
			Collections.sort(list, 
				//���� ����� ���� ������ �����Ѵ�
				(o1, o2)->
					Integer.compare(o1.paper,o2.paper)
			);
			
			int ans=count; //�հ��ڴ� ��ü �����ڷ� �ʱ�ȭ
			int in=list.get(0).interview;//���� 1���� ���� ����� �ʱ�ȭ
			for(int j=1; j<list.size(); j++) {
				//���� ����� ���� �� -> j ���� ������ �� ���� ���� ���� ����͸� ���ϸ� ��
				int cur=list.get(j).interview; //���� �˻��ϴ� �������� ���� ���
				if(in < cur){//����� ���� ������� ������
					ans--;//����
				}
				if(cur < in)//������
					in=cur;//max�� ������Ʈ 
			}
			
			System.out.println(ans);
		}
	}

}





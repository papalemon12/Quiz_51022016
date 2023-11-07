/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz51022016_dat;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;

/**
 *
 * @author Lab20703
 */
public class QuizSimpanData {
    int L=0, TL=0;
    public void SimpanD(String nim, String nama, String NTugas, String NQuiz, String NMid, String NFinal, String NAkhir, String Nhuruf){
        try{
            FileOutputStream fout=new FileOutputStream("QUIZ51022016.dat",true);
            DataOutputStream out=new DataOutputStream(fout);
            out.writeUTF(nim);
            out.writeUTF(nama);
            out.writeUTF(NTugas);
            out.writeUTF(NQuiz);
            out.writeUTF(NMid);
            out.writeUTF(NFinal);
            out.writeUTF(NAkhir);
            out.writeUTF(Nhuruf);
            out.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
    
    }
    
public String ReadData(){
        String nim,nama,NTugas,NQuiz,NMid,NFinal,NAkhir,Nhuruf;
        String temp="",data="";
        try{
            FileInputStream fin=new FileInputStream("QUIZ51022016.dat");
            DataInputStream in=new DataInputStream(fin);
          
            while (in.available()>0){
                nim=in.readUTF();
                nama=in.readUTF();
                NTugas=in.readUTF();
                NQuiz=in.readUTF();
                NMid=in.readUTF();
                NFinal=in.readUTF();
                NAkhir=in.readUTF();     
                Nhuruf=in.readUTF();  
                if (Nhuruf.equals("E")){
                    TL++;
                }
                if (!Nhuruf.equals("E")){
                     L++;
                 }     
                
                temp="nim= "+nim+"\n nama= "+nama+"\n tugas= "+NTugas+"\n quiz= "+NQuiz+"\n mid= "+NMid+"\n nilai final= "+NFinal+"\n nilai akhir= "+NAkhir+"\n nilai huruf="+Nhuruf+"\n ";  //bentuk string
                data+=temp; //masukkan setiap data ke string akhir
            }                              
            in.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
        return(data);
    }
    public int getL(){
        return L;
    }
     public int getTL(){
        return TL;
    }
}
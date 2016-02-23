package ed2;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC-Ed
 */
public class ManipuladorSequencial implements FileOrganizer{

    private FileChannel canal;
    
    public ManipuladorSequencial(String path) throws FileNotFoundException{
        File file = new File(path);
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        this.canal = rf.getChannel();
    }
    
    @Override
    public void addReg(Aluno a) {
        int matric = a.getMatricula();
        try {
            ByteBuffer buf = ByteBuffer.allocate(157);
            if(canal.size() == 0)
                canal.write(a.getByteBuffer());
            else {
                int total = (int) (canal.size()/157);                
                for (int i = 1; i < total + 1; i++) {
                    if(i!=1)
                        canal.position(canal.size() - (i+1)*157);
                    else
                        canal.position(canal.size() - 157);
                    canal.read(buf);
                    buf.flip();
                    int x = buf.getInt();
                    buf.clear();
                    if (x < matric) {
                        canal.write(a.getByteBuffer());
                        buf.clear();
                        break;
                    }
                    else {
                        canal.write(buf);
                        buf.clear();
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ManipuladorSequencial.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        System.out.println("Aluno adicionado!");
    }

    @Override
    public Aluno delReg(int matric) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno getReg(int matric) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
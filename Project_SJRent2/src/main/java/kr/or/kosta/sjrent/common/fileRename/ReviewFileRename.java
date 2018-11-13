package kr.or.kosta.sjrent.common.fileRename;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class ReviewFileRename implements FileRenamePolicy {
	private int userSeq;
	@Override
	public File rename(File f) {
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
        int randomNumber = (int)(Math.random()*100000);
  
        String uniqueFileName = "" + userSeq +"_"+ simDf.format(new Date(currentTime));
        String name = f.getName();
        String body = null;
        String ext = null;
        int dot = name.lastIndexOf(".");
        if (dot != -1) {
             body = name.substring(0, dot);
             ext = name.substring(dot);  // includes "."
        }
        else {
             body = name;
             ext = "";
        }
        String tempName = uniqueFileName + ext;
        f = new File(f.getParent(), tempName);
        if (createNewFile(f)) {
             return f;
        }
        int count = 0;
        while (!createNewFile(f) && count < 9999) {
             count++;
             String newName = uniqueFileName + "_" + count + ext;
             f = new File(f.getParent(), newName);
        }
        return f;
	}
    private boolean createNewFile(File f) {
        try {
             return f.createNewFile();
        }
        catch (IOException ignored) {
             return false;
        }
   }
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
   
}

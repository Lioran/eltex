import java.util.*;
import java.net.*;
import java.io.*;
import java.nio.file.*;

class MyThreadOther implements Runnable{
    private static Socket clientDialog;
    MyThreadOther(Socket socket){
        MyThreadOther.clientDialog = socket;
    }
    public String getPath(String request){
        String ret = request.substring(4);
        ret = ret.substring(0, ret.indexOf(" "));
        return ret;
    }
    public void run(){
        try{
            InputStream inStream = clientDialog.getInputStream();
            OutputStream outStream = clientDialog.getOutputStream();
            Scanner in = new Scanner(inStream);
            byte[] buffer = new byte[64*1024];
            int bytes = inStream.read(buffer);
            System.out.println(bytes);
            String request  = new String(buffer, 0, bytes);
            System.out.println(request);
            String path = getPath(request);
            if(path.equals("/")) path = "/home/dimas";
            System.out.println(path);
            File file = new File(path);
            boolean exist = !file.exists();
            System.out.println(!exist);
            if(!exist){
                if(file.isDirectory())
                    if(path.lastIndexOf(""+File.separator) == path.length()-1){
                            path = path + "index.html";
                    }
                    else{
                        path = path + File.separator + "index.html";
                        file = new File(path);
                        exist = !file.exists();
                    }
                System.out.println(exist);
            }
            if(exist){
                String response = "HTTP/1.1 404 Not Found\n";
                response += "Date: " + new Date() + "\n";
                response += "Content-Type: text/plain\n";
                response += "Connection close\n";
                response += "Server: Server\n";
                response += "Pragma: no-cache\n\n";
                response += "File " + path + " Not Found!";
                outStream.write(response.getBytes());
                clientDialog.close();
                return;
            }else{
                int ex = path.lastIndexOf(".");
                String mimeType = "text/plain";
                if(ex>0){
                    String format = path.substring(ex);
                    if(format.equalsIgnoreCase(".html"))
                        mimeType = "text/html";
                    else if(format.equalsIgnoreCase(".jpeg"))
                        mimeType = "image/jpeg";
                    else if(format.equalsIgnoreCase(".gif"))
                        mimeType = "image/gif";
                }
                String response = "HTTP/1.1 200 OK\n";
                response += "Last-Modified: " + new Date(file.lastModified()) + "\n";
                response += "Content-Length: " + file.length() + "\n";
                response += "Content-Type: " + mimeType + "\n";
                response +="Connection: close\n";
                response += "Server: Server\n\n";
                outStream.write(response.getBytes());
            }
            FileInputStream fis = new FileInputStream(path);
            int write = 1;
            while(write > 0) {
                write = fis.read(buffer);
                if(write > 0) outStream.write(buffer, 0, write);
            }
            fis.close();
            clientDialog.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

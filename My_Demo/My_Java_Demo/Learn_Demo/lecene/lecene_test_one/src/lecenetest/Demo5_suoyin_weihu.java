package lecenetest;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

/**
 * @PackageName：lecenetest
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/23 19:20
 */
public class Demo5_suoyin_weihu {
    public static void main(String[] args) throws Exception {
        //创建Directory对象，将索引库保存在磁盘
        Directory directory = FSDirectory.open(new File("D:\\tmp\\index_test01").toPath());
        //基于Directory对象创建一个IndexWriter对象
        IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig());
        //读取磁盘上的文件，对应每个文件创建一个文档对象
        File dir = new File("D:\\tmp\\lecene");
        File[] files = dir.listFiles();
        for (File f : files) {
            //文件名
            String fileName = f.getName();
            //文件路径
            String path = f.getPath();
            //文件内容
            String fileContent = FileUtils.readFileToString(f, "utf-8");
            //文件大小
            long fileSize = FileUtils.sizeOf(f);
            //创建域(Field)
            // 参数1  域的名称   参数2 域的内容   参数3 是否存储
            Field fieldName = new TextField("name", fileName, Field.Store.YES);
//            Field fieldpath = new TextField("path",path,Field.Store.YES);
            Field fieldpath = new StoredField("path", path);
            Field fieldcontent = new TextField("content", fileContent, Field.Store.YES);
//            Field fieldSize = new TextField("size",fileSize+"",Field.Store.YES);
            Field fieldSizeValue = new LongPoint("size", fileSize);
            Field fieldSizeStore = new StoredField("size", fileSize);
            //向文档对象中添加域
            Document document = new Document();
            document.add(fieldName);
            document.add(fieldpath);
            document.add(fieldcontent);
//            document.add(fieldSize);
            document.add(fieldSizeValue);
            document.add(fieldSizeStore);

            //把文档对象写入索引库
            indexWriter.addDocument(document);
        }
        //关闭IndexWriter对象
        indexWriter.close();
    }
}

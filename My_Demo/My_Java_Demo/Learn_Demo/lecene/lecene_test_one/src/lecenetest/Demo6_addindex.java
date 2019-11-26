package lecenetest;

import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;

/**
 * @PackageName：lecenetest
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/23 19:43
 */
public class Demo6_addindex {
    public static void main(String[] args) throws Exception{
        //索引库存放路径
        Directory directory = FSDirectory.open(new File("D:\\temp\\index").toPath());
        IndexWriterConfig config = new IndexWriterConfig(new IKAnalyzer());
        //创建一个indexwriter对象
        IndexWriter indexWriter = new IndexWriter(directory, config);
        //创建一个Document对象
        Document document = new Document();
        //向document对象中添加域。
        //不同的document可以有不同的域，同一个document可以有相同的域。
        document.add(new TextField("filename", "新添加的文档", Field.Store.YES));
        document.add(new TextField("content", "新添加的文档的内容", Field.Store.NO));
        //LongPoint创建索引
        document.add(new LongPoint("size", 1000L));
        //StoreField存储数据
        document.add(new StoredField("size", 1000L));
        //不需要创建索引的就使用StoreField存储
        document.add(new StoredField("path", "d:/temp/1.txt"));
        //添加文档到索引库
        indexWriter.addDocument(document);
        //关闭indexwriter
        indexWriter.close();
    }

}

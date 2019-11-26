package lecenetest;

import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;

/**
 * @PackageName：lecenetest
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/23 19:49
 */
public class Demo9_updateIndex {
    public static void main(String[] args) {

        IndexWriter indexWriter = getIndexWriter();
//创建一个Document对象
        Document document = new Document();
//向document对象中添加域。
//不同的document可以有不同的域，同一个document可以有相同的域。
        document.add(new TextField("filename", "要更新的文档", Field.Store.YES));
        document.add(new TextField("content", " Lucene 简介 Lucene 是一个基于 Java 的全文信息检索工具包,"+
                "它不是一个完整的搜索应用程序,而是为你的应用程序提供索引和搜索功能。",
                Field.Store.YES));
        indexWriter.updateDocument(new Term("content", "java"), document);
//关闭indexWriter
        indexWriter.close();

    }
}

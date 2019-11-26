package lecenetest;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

/**
 * @PackageName：lecenetest
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/23 18:42
 */
public class Demo2 {
    public static void main(String[] args) throws Exception{
        //指定索引库存放的路径
        //D:\temp\index
        Directory directory = FSDirectory.open(new File("D:\\tmp\\index_test01").toPath());
        //创建indexReader对象
        IndexReader indexReader = DirectoryReader.open(directory);
        //创建indexsearcher对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //创建查询
        /*关键词所在的域，关键词本身   content文件本身，path文件路径，name文件名称，size文件大小*/
        Query query = new TermQuery(new Term("content", "java"));
        //执行查询
        //第一个参数是查询对象，第二个参数是查询结果返回的最大值
        TopDocs topDocs = indexSearcher.search(query, 10);
        //查询结果的总条数
        System.out.println("查询结果的总条数："+ topDocs.totalHits);
        //遍历查询结果
        //topDocs.scoreDocs存储了document对象的id
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            //scoreDoc.doc属性就是document对象的id
            //根据document的id找到document对象
            Document document = indexSearcher.doc(scoreDoc.doc);
            System.out.println("文件名:"+document.get("name"));
            System.out.println("文件内容:"+document.get("content"));
            System.out.println("文件路径:"+document.get("path"));
            System.out.println("文件大小:"+document.get("size"));
            System.out.println("-------------------------");
        }
        //关闭indexreader对象
        indexReader.close();
    }

}

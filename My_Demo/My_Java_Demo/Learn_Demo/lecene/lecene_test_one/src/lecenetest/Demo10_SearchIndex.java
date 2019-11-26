package lecenetest;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

/**
 * @PackageName：lecenetest
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/23 19:50
 */
public class Demo10_SearchIndex {
    private static IndexReader indexReader;
    private static IndexSearcher indexSearcher;

    public static void main(String[] args) throws IOException {

        indexReader = DirectoryReader.open(FSDirectory.open(new File("c:\\io\\index").toPath()));
        indexSearcher = new IndexSearcher(indexReader);

        //创建一个Query对象
        Query query = LongPoint.newRangeQuery("size", 0, 100);
        TopDocs topDocs = indexSearcher.search(query, 10);
        System.out.println("总记录数:" + topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document document = indexSearcher.doc(doc);
            System.out.println(document.get("name"));
            System.out.println(document.get("path"));
            System.out.println(document.get("size"));
        }
        indexReader.close();

    }


}

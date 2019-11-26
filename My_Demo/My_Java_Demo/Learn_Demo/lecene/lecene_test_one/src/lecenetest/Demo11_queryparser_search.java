package lecenetest;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * @PackageName：lecenetest
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/23 19:53
 */
public class Demo11_queryparser_search {
    public static void main(String[] args) {
        QueryParser queryParser = new QueryParser("name", new IKAnalyzer());
        Query query = queryParser.parse("lucene是一个Java开发的全文检索工具包");
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

package lecenetest;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;

/**
 * @PackageName：lecenetest
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/23 19:48
 */
public class Demo8_deleteIndexById {
    public static void main(String[] args) {
        IndexWriter indexWriter = getIndexWriter();
        //创建一个查询条件
        Query query = new TermQuery(new Term("name", "apache"));
        //根据查询条件删除
        indexWriter.deleteDocuments(query);
        //关闭indexwriter
        indexWriter.close();

    }
}

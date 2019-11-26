package lecenetest;

import org.apache.lucene.index.IndexWriter;

/**
 * @PackageName：lecenetest
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/23 19:47
 */
public class Demo7_deleteAllIndex {
    public static void main(String[] args) {
        IndexWriter indexWriter = getIndexWriter();
        //删除全部索引
        indexWriter.deleteAll();
        //关闭indexwriter
        indexWriter.close();

    }
}

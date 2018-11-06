package me.codebase.es;

import com.alibaba.fastjson.JSON;
import me.codebase.es.bean.RiskSlotCityStatisDto;
import me.codebase.es.config.ElasticConfig;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.stream.StreamSupport;

public class Test {

    public static void main(String[] args) throws Exception {
        SearchRequest searchRequest = new SearchRequest("tuia_risk_dev"); // 限制请求到某个索引上
        searchRequest.types("tb_risk_slot_city_statis"); // 限制请求的类别
        // 大多数的搜索参数被添加到 SearchSourceBuilder 。它为每个进入请求体的每个东西都提供 setter 方法。
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 添加一个 match_all 查询到 searchSourceBuilder 。
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.from(4990);
        searchSourceBuilder.size(10);
        searchRequest.source(searchSourceBuilder);

        //MatchQueryBuilder matchbuilder = QueryBuilders.matchQuery("message", keyword1 + " " + keyword2);
        // 同时满足两个关键字
        //matchbuilder.operator(Operator.AND);

        // 查询在时间区间范围内的结果
        RangeQueryBuilder rangbuilder = QueryBuilders.rangeQuery("cur_date");
        String startDate = "2018-10-14";
        String endDate = "2018-10-24";
        rangbuilder.gte(startDate);
        rangbuilder.lte(endDate);
        // 等同于bool，将两个查询合并
/*        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(QueryBuilders.matchPhraseQuery("slot_id", 151L));
        boolBuilder.must(rangbuilder);
        searchSourceBuilder.query(boolBuilder);*/
        // 排序
        FieldSortBuilder fsb = SortBuilders.fieldSort("cur_date");
        fsb.order(SortOrder.DESC);
        searchSourceBuilder.sort(fsb);


        try (RestHighLevelClient restHighLevelClient = ElasticConfig.getInstance()) {
            boolean s = restHighLevelClient.exists(new GetRequest("tuia_risk_dev", "tb_risk_slot_city_statis", "VxqQpGYBRexmWEJ48iCc"));
            System.out.println(s);
            long begin = System.currentTimeMillis();
            SearchResponse searchResponse = null;
            try {
                searchResponse = restHighLevelClient.search(searchRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            SearchHits hits = searchResponse.getHits();
            System.out.println(hits.getTotalHits());
            System.out.println("耗时1：" + (System.currentTimeMillis() - begin));
            StreamSupport.stream(hits.spliterator(), false)
                    .map(hit -> JSON.parseObject(hit.getSourceAsString(), RiskSlotCityStatisDto.class))
                    .forEach(System.out::println);
            System.out.println("耗时2：" + (System.currentTimeMillis() - begin));
        }
    }
}

--
register /home/cloudera/mntTCS/jnjudf.jar
register /usr/lib/pig/piggybank.jar;
register /usr/lib/pig/pig.jar;

DEFINE MULT com.vulcan.operation.reducer.Multiplication();

rmf Genealogy_Calculation_Output
--inputData = load '1.799601_genealogy_data.txt' using PigStorage('\t') as (ID, START_LOT, END_LOT, START_LOT_ID, END_LOT_ID, LEVEL_NUM, IS_CYCLE, IS_LEAF, LOT_PATH, AMOUNT_PATH, LOT_ID_PATH, DAY_WINDOW_PATH, CNTR_CNT_PATH, MIN_DAY_WINDOW_ID);
inputData = load 'flg.txt' using PigStorage('\t') as (ID, START_LOT, END_LOT, START_LOT_ID, END_LOT_ID, LEVEL_NUM, IS_CYCLE, IS_LEAF, LOT_PATH, AMOUNT_PATH, LOT_ID_PATH, DAY_WINDOW_PATH, CNTR_CNT_PATH, MIN_DAY_WINDOW_ID);

joinData = load 'JoinTable.txt' using PigStorage('\t') as (LOOKUP_IN, LOOKUP_OUT);

splitData = foreach inputData generate $3, $4, STRSPLIT($10, '\\.') as LOT_IDS, STRSPLIT($9, '\\|') as AMOUNTS, $13;
--splitData = FILTER splitData BY (END_LOT_ID eq 96) AND (MIN_DAY_WINDOW_ID eq 0);

splitData = foreach splitData generate START_LOT_ID, END_LOT_ID, MIN_DAY_WINDOW_ID, AMOUNTS.$1 * AMOUNTS.$2 * AMOUNTS.$3 * AMOUNTS.$4 * AMOUNTS.$5 as AMOUNTS;
--splitData = foreach splitData generate START_LOT_ID, END_LOT_ID, MIN_DAY_WINDOW_ID, AMOUNTS.$1 as AMOUNTS;

-- this group by needs to be replaced by a UDF which does MULTIPLY instead of SUM
grp = GROUP splitData by (START_LOT_ID, END_LOT_ID, MIN_DAY_WINDOW_ID);
splitData = FOREACH grp GENERATE flatten(group) as (START_LOT_ID, END_LOT_ID, MIN_DAY_WINDOW_ID), MULT(splitData.AMOUNTS);
splitData = JOIN splitData BY MIN_DAY_WINDOW_ID, joinData BY LOOKUP_IN;
splitData = ORDER splitData BY START_LOT_ID, END_LOT_ID, MIN_DAY_WINDOW_ID, LOOKUP_OUT;
store splitData into 'Genealogy_Calculation_Output';

--describe splitData;

--first_element = foreach splitData generate LOT_IDS.$1, AMOUNTS.$1, org.apache.pig.builtin.SIZE(LOT_IDS);
--dump first_element;

--dump splitData.LOT_IDS(0), splitData.LOT_IDS(1);
--splitFlattenData = foreach splitData generate $0, $1, $2, FLATTEN($3), $4;

--one_word_per_line= FOREACH splitFlattenData GENERATE FLATTEN(TOBAG($2));

--dump one_word_per_line;
--fooData = foreach splitData GENERATE $0, $1, $2, org.apache.pig.builtin.SIZE($3);

--dump splitFlattenData;
--dump fooData;
--describe splitFlattenData;

 

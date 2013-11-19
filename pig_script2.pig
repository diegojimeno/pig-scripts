-- Requires a jar and defines an alias to an UDF function
REGISTER '/Users/fromnortherncalifornia/Documents/pig/pig_udfs/target/pig_udfs-0.1.jar';

DEFINE UNBAG org.diegojimeno.eiae.basic_udfs.Unbag();

-- Extract phase
loaded = LOAD '/Users/fromnortherncalifornia/Desktop/coursera/PIG SAMPLES/dataSets/baseball.txt' USING PigStorage('\t','-noschema') AS (name:chararray, team:chararray, position:bag{t:(p:chararray)}, bat:map[]);

-- Transforming phase
pivot = FOREACH loaded GENERATE name, team, FLATTEN(UNBAG(position));
DUMP pivot;

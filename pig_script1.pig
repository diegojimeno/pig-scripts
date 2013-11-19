-- Register the package and define the function
REGISTER '/Users/fromnortherncalifornia/Documents/pig/pig_udfs/target/pig_udfs-0.1.jar';

DEFINE POW org.diegojimeno.eiae.basic_udfs.Pow();
-- Loading of defined java methods
DEFINE toString InvokeForString('java.lang.Long.toString', 'long');

-- Load input with complex types
loaded = LOAD '/Users/fromnortherncalifornia/Desktop/coursera/PIG SAMPLES/POW_test.txt' USING PigStorage(',') AS (base:INT, exponent: INT);

		
-- AS (name:chararray, team:chararray, position:bag{t:(p:chararray)}, bat:map[]);

result = FOREACH loaded GENERATE toString(POW(base, exponent));
STORE result INTO '/Users/fromnortherncalifornia/Desktop/coursera/PIG SAMPLES/result.txt';

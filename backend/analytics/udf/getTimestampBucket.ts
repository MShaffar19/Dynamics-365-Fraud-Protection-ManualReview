function getTimestampBucket(start_timestamp, period_in_seconds, target_timestamp){
    return Math.floor((target_timestamp - start_timestamp) / period_in_seconds);
}
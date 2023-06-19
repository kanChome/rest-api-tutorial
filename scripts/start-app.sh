#!/bin/bash
set -eux
script_dir_path=$(dirname $(readlink -f $0))
MVNW=$script_dir_path/../mvnw

$MVNW package
cp $script_dir_path/../target/*.jar $script_dir_path/../docker
# (
#   cd $script_dir_path/../
#   docker-compose up -d
# )
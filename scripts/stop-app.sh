#!/bin/bash
set -eux
script_dir_path=$(dirname $(readlink -f $0))

(
  cd $script_dir_path/../
  docker-compose down
)
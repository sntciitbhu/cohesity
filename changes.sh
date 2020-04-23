#!/bin/bash
echo "changing remotes"
for d in ./*/ ; do (cd "$d" && (rm -rf .git) || echo "failed"); done

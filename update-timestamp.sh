#!/bin/bash
   # Update the Last Modified line in the file
   FILE="$1"
   TIMESTAMP=$(date "+%B %d, %Y. at %l:%M %p")
   
   # Use sed to replace the Last Modified line
   sed -i "s|// Last Modified:.*|// Last Modified: $TIMESTAMP|g" "$FILE"

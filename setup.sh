#!/bin/bash

# Set up the commit template
echo "Setting up commit template..."
git config commit.template .git-hooks/commit-template

# Set up Git hooks
echo "Setting up Git hooks..."
HOOKS_DIR=".git/hooks"
CUSTOM_HOOKS_DIR=".git-hooks"

if [ -d "$CUSTOM_HOOKS_DIR" ]; then
  for hook in "$CUSTOM_HOOKS_DIR"/*; do
    hook_name=$(basename "$hook")
    cp "$hook" "$HOOKS_DIR/$hook_name"
    chmod +x "$HOOKS_DIR/$hook_name"
    echo "Installed $hook_name hook."
  done
else
  echo "Custom hooks directory ($CUSTOM_HOOKS_DIR) not found."
fi

echo "Setup complete."